package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
@Autonomous(name="ForwardLineLeft")
public class HowlersAutoForwardLineLeft extends HowlersAutoFunction {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){
        initRobot();
        waitForStart();
        encoderDrive(0.4,1,1); // keep negative for forward, 3 is ninety degree
        encoderStrafe(0.4,1,-1); // keep negative for forward, 3 is ninety degree
    }

    public void delay(double time){

    }
}
