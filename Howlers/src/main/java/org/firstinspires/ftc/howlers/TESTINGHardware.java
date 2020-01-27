package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class TESTINGHardware {
    public DcMotor rightFront = null;

    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    public TESTINGHardware(){

    }

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        rightFront = hwMap.get(DcMotor.class, "rightFront");

        //drive train
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);


        rightFront.setPower(0);


        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

}


