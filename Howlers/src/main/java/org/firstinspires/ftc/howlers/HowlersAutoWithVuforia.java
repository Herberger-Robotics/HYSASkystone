package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

//import org.firstinspires.ftc.howlers.HowlersHardware;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

@Autonomous(name="HowlersAutoMainForTesting")
public class HowlersAutoWithVuforia extends HowlersAutoFunction {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();

    private static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
    private static final boolean PHONE_IS_PORTRAIT = false  ;



    private static final String VUFORIA_KEY =
            "AdWlmRL/////AAABmR6HEi8caUNulL+O+TccAf4rW7c2xMm9TodMQFWHmHokXLNO9htpsD1aE9lpgtjkf6/Z/eJQQ9WuVC6g4f4I1Uo0+R9b1gJX9F8X9VIOFX7fIcfN6vRaGGoV/YuJ4lBm+eOu969IbDZymrgIwe1fukuo73VGB+PdWMYgVwyt612sqzaeUopvLs19mh1WlsKupNGdC4M3lbgcF/Ty6IHfgIbZJPCYwcegtZ50pEkcmjh6WIq3lyzq/3sNgsKcF4TNIQtyBeUmeDZk9mSBlkliRPvx5cHTzUjLvB3zLVVvGbRgNS9TSAZ15a/+Fa5zVPIVyoMdxgNtzzY7EKAWNBG5CqcthGJqF3rR2fs9ImWCvHrJ";


    // Since ImageTarget trackables use mm to specifiy their dimensions, we must use mm for all the physical dimension.
    // We will define some constants and conversions here
    private static final float mmPerInch        = 25.4f;
    private static final float mmTargetHeight   = (6) * mmPerInch;          // the height of the center of the target image above the floor

    // Constant for Stone Target
    private static final float stoneZ = 2.00f * mmPerInch;

    // Constants for the center support targets
    private static final float bridgeZ = 6.42f * mmPerInch;
    private static final float bridgeY = 23 * mmPerInch;
    private static final float bridgeX = 5.18f * mmPerInch;
    private static final float bridgeRotY = 59;                                 // Units are degrees
    private static final float bridgeRotZ = 180;

    // Constants for perimeter targets
    private static final float halfField = 72 * mmPerInch;
    private static final float quadField  = 36 * mmPerInch;

    // Class Members
    private OpenGLMatrix lastLocation = null;
    private VuforiaLocalizer vuforia = null;
    private boolean targetVisible = false;
    private float phoneXRotate    = 0;
    private float phoneYRotate    = 0;
    private float phoneZRotate    = 0;

    public double skystoneLocation = 0;









    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        waitForStart();












    }

    public void stopAndReset(){
        robot.leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }


    public void encoderLift(double speed, double rotations){
        int liftTarget;

        if(opModeIsActive()){

            liftTarget = robot.liftClaw.getCurrentPosition() + (int)((rotations) * (2789));

            robot.liftClaw.setTargetPosition(liftTarget);

            robot.liftClaw.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.liftClaw.setPower(Math.abs(speed));

            while(opModeIsActive() && robot.liftClaw.isBusy()){

            }

            robot.liftClaw.setPower(0);

            robot.liftClaw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }


    }


    public void encoderDrive(double speed, double rightRotations, double leftRotations){
        int backrightTarget;
        int backleftTarget;
        int frontrightTarget;
        int frontleftTarget;





        if(opModeIsActive())
        {
            frontrightTarget = robot.rightFront.getCurrentPosition() + (int)((rightRotations) * (1497.325));
            frontleftTarget = robot.leftFront.getCurrentPosition() + (int)((leftRotations) * (1497.325));
            backleftTarget = robot.leftBack.getCurrentPosition() + (int)((leftRotations) * (1497.325));
            backrightTarget = robot.rightBack.getCurrentPosition() + (int)((rightRotations) * (1497.325));

            /*robot.rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            robot.rightRear.setDirection(DcMotorSimple.Direction.FORWARD);
            robot.leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
            robot.leftFront.setDirection(DcMotorSimple.Direction.REVERSE);*/

            robot.rightFront.setTargetPosition(frontrightTarget);
            robot.leftFront.setTargetPosition(frontleftTarget);
            robot.rightBack.setTargetPosition(backrightTarget);
            robot.leftBack.setTargetPosition(backleftTarget);

            robot.rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.rightFront.setPower(Math.abs(speed));
            robot.rightBack.setPower(Math.abs(speed));
            robot.leftFront.setPower(Math.abs(speed));
            robot.leftBack.setPower(Math.abs(speed));

            while (opModeIsActive() && robot.leftBack.isBusy() && robot.leftFront.isBusy() && robot.rightBack.isBusy() && robot.rightFront.isBusy() )
            {

            }

            robot.rightBack.setPower(0);
            robot.rightFront.setPower(0);
            robot.leftFront.setPower(0);
            robot.leftBack.setPower(0);

            robot.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }

    /*public void turnRight(double speed, double rightRotations, double leftRotations){
        int backrightTarget;
        int backleftTarget;
        int frontrightTarget;
        int frontleftTarget;


        if(opModeIsActive())
        {
            frontrightTarget = robot.rightFront.getCurrentPosition() + (int)(rightRotations) * (538);
            frontleftTarget = robot.leftFront.getCurrentPosition() + (int)(leftRotations) * (538);
            backleftTarget = robot.leftFront.getCurrentPosition() + (int)(leftRotations) * (538);
            backrightTarget = robot.rightRear.getCurrentPosition() + (int)(rightRotations) * (538);

            robot.rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
            robot.rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            robot.leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            robot.leftRear.setDirection(DcMotorSimple.Direction.REVERSE);

            robot.rightFront.setTargetPosition(frontrightTarget);
            robot.leftFront.setTargetPosition(frontleftTarget);
            robot.rightRear.setTargetPosition(backrightTarget);
            robot.leftRear.setTargetPosition(backleftTarget);

            robot.rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.rightFront.setPower(Math.abs(speed));
            robot.rightRear.setPower(Math.abs(speed));
            robot.leftFront.setPower(Math.abs(speed));
            robot.leftRear.setPower(Math.abs(speed));

            while (opModeIsActive() && robot.leftRear.isBusy() && robot.leftFront.isBusy() && robot.rightRear.isBusy() && robot.rightFront.isBusy() )
            {

            }

            robot.rightRear.setPower(0);
            robot.rightFront.setPower(0);
            robot.leftFront.setPower(0);
            robot.leftRear.setPower(0);

            robot.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        }

    }*/

    public void delay(double time){




    }

    public void vuforiaSkystone()
    {


        // Disable Tracking when we are done;



    }










}
