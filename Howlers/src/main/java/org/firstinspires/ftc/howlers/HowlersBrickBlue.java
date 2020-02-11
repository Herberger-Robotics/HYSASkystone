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
        robot.clawServo.setPosition(0.7);
        encoderDrive(speed,0.55,0.55);//forward
        String stonePos = findPosition(speed);
        telemetry.addData("stonePos: ", stonePos);
        telemetry.update();
        pickUpSkystone(speed, stonePos, true);
    }

}
