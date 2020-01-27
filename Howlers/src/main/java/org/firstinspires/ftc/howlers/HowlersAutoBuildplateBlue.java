package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BuildplateBlue")
public class HowlersAutoBuildplateBlue extends HowlersAutoFunction {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){
        initRobot();
        waitForStart();
        //encoderDrive(0.4,1,1);
        //encoderStrafe(0.4,1,-1);
        //encoderDrive(0.4, 0.1, 0.1);
        encoderLift(0.4,0.000000000000000000001);
    }
}
