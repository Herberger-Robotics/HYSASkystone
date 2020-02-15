package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BrickBlue")
public class HowlersBrickBlue extends HowlersAutoFunction {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){
        double speed = 0.4;
        initRobot();
        robot.init(hardwareMap);
        telemetry.addData("Status:","Initialized");
        telemetry.update();
        waitForStart();
        robot.clawServo.setPosition(0.5);
        encoderDrive(speed,0.55,0.55);//forward
        String stonePos = null;
        if(detectSkystone()) {
            stonePos = "left";
        } else {
            encoderStrafe(speed, -0.3, 0.3); //right
            if (detectSkystone()) {
                stonePos = "center";
            } else {
                encoderStrafe(speed, -0.3, 0.3); //right
                stonePos = "right";
            }
        }
        telemetry.addData("stonePos: ", stonePos);
        telemetry.update();
        switch(stonePos) {
            case "left": {
                encoderStrafe(speed,0.15,-0.15); //left
                encoderDrive(speed,0.5,0.5);//forwards
                robot.clawServo.setPosition(0.2);//close
                robotWait(0.5);
                encoderDrive(speed,-0.35,-0.35);//backwards
                encoderStrafe(speed,3.5,-3.5);//left
                encoderStrafe(speed,-0.2,0.2);//right
                encoderLift(speed, -1);//raise
                encoderDrive(speed,0.45,0.45);//forwards
                robot.clawServo.setPosition(0.5);//open
                robotWait(0.5);
                encoderDrive(speed,-0.1,-0.1);//backwards
                encoderLift(speed,1);//lower
                encoderStrafe(speed,-5,5);//right
                encoderStrafe(speed,0.3,-0.3);//left
                encoderDrive(speed,1,1);
                robot.clawServo.setPosition(0.2);
                robotWait(0.5);
                encoderDrive(speed,-1,-1);
                encoderStrafe(speed,0.4,-0.3);//left
            }
            case "center": {

            }
            case "right": {

            }
        }

    }

}
