package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BuildplateBlueWall")
public class HowlersAutoBuildplateRedWall extends HowlersAutoFunction {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode(){
        double speed = 0.4;
        initRobot();
        waitForStart();
        encoderDrive(speed,1,1); //forwards
        encoderStrafe(speed,-1,1); //right
        encoderLift(speed,-1);//raise
        encoderDrive(speed, 0.3, 0.3);//forwards
        encoderLift(speed,1);//lower
        encoderDrive(speed,-1.3,-1.3);//backwards
        encoderLift(speed,-1);
        encoderStrafe(speed,1,-1); //left
        encoderLift(speed,1);
        encoderStrafe(speed,1,-1); //left

    }
}
