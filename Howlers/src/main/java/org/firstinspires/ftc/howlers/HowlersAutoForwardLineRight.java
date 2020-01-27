package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="ForwardLineRight")
public class HowlersAutoForwardLineRight extends HowlersAutoFunction {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){
        initRobot();
        waitForStart();
        encoderDrive(0.4,1,1); // keep negative for forward, 3 is ninety degree
        encoderStrafe(0.4,-1,1);
    }



    public void delay(double time){

    }
}
