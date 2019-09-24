package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class basicAuto extends LinearOpMode {

    HardwareClass robot = new HardwareClass();
    private ElapsedTime runtime = new ElapsedTime();





    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        stopAndReset();

        waitForStart();

        encoderDrive(1, 1);



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


    public void encoderDrive(double speed, double rotations){
        int rightTarget;
        int leftTarget;


        if(opModeIsActive())
        {
            rightTarget = robot.rightFront.getCurrentPosition() + (int)(rotations) * (1440);
            leftTarget = robot.leftFront.getCurrentPosition() + (int)(rotations) * (1440);

            robot.rightFront.setTargetPosition(rightTarget);
            robot.leftFront.setTargetPosition(leftTarget);
            robot.rightBack.setTargetPosition(rightTarget);
            robot.leftBack.setTargetPosition(leftTarget);

            robot.rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.rightFront.setPower(speed);
            robot.rightBack.setPower(speed);
            robot.leftFront.setPower(speed);
            robot.leftBack.setPower(speed);

            while (opModeIsActive() && robot.leftBack.isBusy() || robot.leftFront.isBusy() || robot.rightBack.isBusy() || robot.rightFront.isBusy() )
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
    public void turnLeft(double speed, double rotations){
        int rightTarget;
        int leftTarget;


        if(opModeIsActive())
        {
            rightTarget = robot.rightFront.getCurrentPosition() + (int)(rotations) * (1440);
            leftTarget = robot.leftFront.getCurrentPosition() + (int)(rotations) * (1440);

            robot.rightFront.setTargetPosition(rightTarget);
            robot.leftFront.setTargetPosition(leftTarget);
            robot.rightBack.setTargetPosition(rightTarget);
            robot.leftBack.setTargetPosition(leftTarget);

            robot.rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.rightFront.setPower(speed);
            robot.rightBack.setPower(speed);
            robot.leftFront.setPower(-speed);
            robot.leftBack.setPower(-speed);

            while (opModeIsActive() && robot.leftBack.isBusy() || robot.leftFront.isBusy() || robot.rightBack.isBusy() || robot.rightFront.isBusy() )
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

    public void turnRight(double speed, double rotations){
        int rightTarget;
        int leftTarget;


        if(opModeIsActive())
        {
            rightTarget = robot.rightFront.getCurrentPosition() + (int)(rotations) * (1440);
            leftTarget = robot.leftFront.getCurrentPosition() + (int)(rotations) * (1440);

            robot.rightFront.setTargetPosition(rightTarget);
            robot.leftFront.setTargetPosition(leftTarget);
            robot.rightBack.setTargetPosition(rightTarget);
            robot.leftBack.setTargetPosition(leftTarget);

            robot.rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.rightFront.setPower(-speed);
            robot.rightBack.setPower(-speed);
            robot.leftFront.setPower(speed);
            robot.leftBack.setPower(speed);

            while (opModeIsActive() && robot.leftBack.isBusy() || robot.leftFront.isBusy() || robot.rightBack.isBusy() || robot.rightFront.isBusy() )
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











}
