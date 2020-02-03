package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BasicBrick")
public class HowlersBasicBrick extends HowlersAutoFunction {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode(){
        double speed = 0.4;
        initRobot();
        waitForStart();
        robot.clawServo.setPosition(0.7);
        encoderDrive(0.5,1.3,1.3);
        robot.clawServo.setPosition(0.1);
        sleep(100);
        encoderStrafe(0.5,-1,1);
        robot.clawServo.setPosition(0.7);
    }
}
