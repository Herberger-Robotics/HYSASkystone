package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BuildplateBlueBridge")
public class HowlersAutoBuildplateBlueBridge extends HowlersAutoFunction {

    HowlersHardware robot = new HowlersHardware();
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode(){
        double speed = 0.4;
        initRobot();
        waitForStart();
        encoderDrive(speed,1,1); //forwards
        encoderStrafe(speed,1,-1); //left
        encoderLift(speed,-1);//raise
        encoderDrive(speed, 0.3, 0.3);//forwards
        encoderLift(speed,1);//lower
        encoderDrive(speed,-1.3,-1.3);//backwards
        encoderLift(speed,-1); // raise
        encoderStrafe(speed,-1.1,1.1);
        encoderLift(speed,1);
        encoderDrive(speed,0.7,0.7);
        encoderStrafe(speed,-0.6,0.6);


        /*encoderDrive(speed,-0.7,-0.5);//backwards
        encoderDrive(speed,0.2,0.2);//forwards
        encoderStrafe(speed,-1,1);//right
        encoderStrafe(speed,-0.7,0.7);//right
        encoderDrive(speed,1.3,1.3); //forwards
        encoderStrafe(speed,1,-1); //left
        encoderLift(speed,-1);//raise
        encoderDrive(speed,-0.5,-0.5);//backwards
        encoderLift(speed,1);//lower
        encoderStrafe(speed,-0.8,0.8);//right
        encoderDrive(speed,-1,-1);//backwards*/
    }
}
