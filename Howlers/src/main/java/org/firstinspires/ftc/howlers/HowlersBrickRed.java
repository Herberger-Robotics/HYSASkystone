package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BrickRed")
public class HowlersBrickRed extends HowlersAutoFunction {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){
        double speed = 0.3;
        initRobot();
        robot.init(hardwareMap);
        robot.liftClaw.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        telemetry.addData("Status:","Initialized");
        telemetry.update();
        waitForStart();
        robot.clawServo.setPosition(0.5);
        sleep(200);
        encoderDrive(speed,0.55,0.55);//forward
        String stonePos = null;
        if(detectSkystone()) {
            stonePos = "left";
        } else {
            encoderStrafe(speed, 0.3, -0.3); //left
            if (detectSkystone()) {
                stonePos = "center";
            } else {
                encoderStrafe(speed, 0.3, -0.3); //left
                stonePos = "right";
            }
        }
        telemetry.addData("stonePos: ", stonePos);
        telemetry.update();
        switch(stonePos) {
            case "left": {
                encoderStrafe(speed,0.15,-0.15); //left
                encoderDrive(0.2,0.55,0.55);//forwards
                sleep(200);
                robot.clawServo.setPosition(0.2);//close
                sleep(200);
                encoderDrive(speed,-0.38,-0.38);//backwards
                encoderStrafe(speed,-1.9,1.9);//right 52~ in
                sleep(200);
                robot.clawServo.setPosition(0.5); // open
                sleep(200);
                encoderStrafe(speed,2.8,-2.8);//left
                encoderDrive(0.2,0.76,0.76); // forward
                sleep(200);
                robot.clawServo.setPosition(0.2);
                sleep(200);
                encoderDrive(speed,-0.5,-0.5);//backwards
                encoderStrafe(speed,-2.8,2.8);//right
                sleep(200);
                robot.clawServo.setPosition(0.5);
                sleep(200);
                encoderStrafe(speed,0.7,-0.7);//left
                robot.clawServo.setPosition(0.2);
                encoderDrive(speed,0.22,0.22);
                break;
            }
            case "center": {
                encoderStrafe(speed,0.15,-0.15); //left
                encoderDrive(0.2,0.6,0.6);//forwards
                robot.clawServo.setPosition(0.2);//close
                sleep(200);
                encoderDrive(speed,-0.42,-0.42);//backwards
                encoderStrafe(speed,-2,2);//right 52~ in
                sleep(500);
                robot.clawServo.setPosition(0.5); // open
                sleep(500);
                encoderDrive(speed,-0.1,-0.1);
                encoderStrafe(speed,2.9,-2.9);//left
                encoderDrive(0.2,0.77,0.77); // forward
                sleep(200);
                robot.clawServo.setPosition(0.2);
                sleep(200);
                encoderDrive(speed,-0.44,-0.44);
                encoderStrafe(speed,-2.8,2.8);//right
                robot.clawServo.setPosition(0.5);
                encoderDrive(speed,-0.1,-0.1);
                encoderStrafe(speed,0.6,-0.6);//left
                sleep(200);
                robot.clawServo.setPosition(0.2);
                sleep(200);
                encoderDrive(speed,0.23,0.23);
                break;
            }
            case "right": {
                encoderStrafe(speed,-0.15,0.15); //right
                encoderDrive(0.2,0.62,0.62);//forwards
                robot.clawServo.setPosition(0.2);//close
                robotWait(0.5);
                encoderDrive(speed,-0.37,-0.37);//backwards
                encoderStrafe(speed,-2.1,2.1);//right 52~ in
                sleep(200);
                robot.clawServo.setPosition(0.5); // open
                sleep(200);
                encoderDrive(speed,-0.1,-0.1);
                encoderStrafe(speed,1.45,-1.45); //left
                encoderDrive(0.2,0.7,0.7);
                sleep(200);
                robot.clawServo.setPosition(0.2);
                sleep(200);
                encoderDrive(speed,-0.45,-0.45);
                encoderStrafe(speed,-1.6,1.6);//right
                sleep(200);
                robot.clawServo.setPosition(0.5);
                sleep(200);
                encoderDrive(speed,-0.1,-0.1);
                encoderStrafe(speed,0.5,-0.5);//left
                sleep(200);
                robot.clawServo.setPosition(0.2);
                sleep(200);
                encoderDrive(speed,0.2,0.2);

                break;
            }
        }

    }

}
