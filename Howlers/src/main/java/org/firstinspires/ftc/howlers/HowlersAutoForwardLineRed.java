package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="ForwardLineRight")
public class HowlersAutoForwardLineRed extends LinearOpMode {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        waitForStart();
        encoderDrive(0.4,-1,-1); // keep negative for forward, 3 is ninety degree
        //encoderStrafe(0.4,-1,1); // keep negative for forward, 3 is ninety degree
    }

    public void stopAndReset(){
        robot.leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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
    public void encoderStrafe(double speed, double rightRotations, double leftRotations){
        int backrightTarget;
        int backleftTarget;
        int frontrightTarget;
        int frontleftTarget;





        if(opModeIsActive())
        {
            frontrightTarget = robot.rightFront.getCurrentPosition() + (int)((rightRotations) * (1497.325));
            frontleftTarget = robot.leftFront.getCurrentPosition() + (int)((leftRotations) * (1497.325));
            backleftTarget = robot.leftBack.getCurrentPosition() - (int)((leftRotations) * (1497.325));
            backrightTarget = robot.rightBack.getCurrentPosition() - (int)((rightRotations) * (1497.325));

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



    public void delay(double time){

    }
}
