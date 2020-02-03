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
        initRobot();
        telemetry.addData("Status:","Initialized");
        telemetry.update();
        waitForStart();
        telemetry.addData("Detected: ", detectSkystone());
        telemetry.update();
    }

}
