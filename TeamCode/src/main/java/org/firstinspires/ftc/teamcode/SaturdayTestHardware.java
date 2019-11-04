package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class SaturdayTestHardware {
    public Servo rightClaw = null;
    //public Servo leftClaw = null;

    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    public SaturdayTestHardware(){

    }

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        rightClaw = hwMap.get(Servo.class, "rightClaw");
        //leftClaw = hwMap.get(Servo.class, "leftClaw");
    }

}


