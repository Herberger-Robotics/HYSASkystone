package org.firstinspires.ftc.howlers;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HowlersHardware {
    public DcMotor rightFront = null;
    public DcMotor rightBack = null;
    public DcMotor leftFront = null;
    public DcMotor leftBack = null;
    public DcMotor liftClaw = null;
    public Servo clawServo = null;

    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    public HowlersHardware(){

    }

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        rightFront = hwMap.get(DcMotor.class, "rightFront");
        rightBack = hwMap.get(DcMotor.class, "rightBack");
        leftBack = hwMap.get(DcMotor.class, "leftBack");
        leftFront = hwMap.get(DcMotor.class,"leftFront");

        liftClaw = hwMap.get(DcMotor.class, "liftClaw");
        clawServo = hwMap.get(Servo.class, "clawServo");

        //drive train
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        //lift
        liftClaw.setDirection(DcMotorSimple.Direction.FORWARD);

        rightBack.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        leftFront.setPower(0);
        liftClaw.setPower(0);


        liftClaw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

}


