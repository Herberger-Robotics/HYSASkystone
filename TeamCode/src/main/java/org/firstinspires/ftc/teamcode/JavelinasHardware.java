package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;


@Disabled
public class JavelinasHardware {
    public DcMotor rightFront = null;
    public DcMotor rightRear = null;
    public DcMotor leftFront = null;
    public DcMotor leftRear = null;
    public CRServo extendArm = null;
    public DcMotor lift = null;
    public Servo servo =null;

    HardwareMap hwMap = null;

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        rightFront = hwMap.get(DcMotor.class, "rightFront");
        rightRear = hwMap.get(DcMotor.class, "rightRear");
        leftFront = hwMap.get(DcMotor.class, "leftFront");
        leftRear = hwMap.get(DcMotor.class, "leftRear");
        extendArm = hwMap.get(CRServo.class, "extendArm");
        lift = hwMap.get(DcMotor.class,"lift");
        servo = hwMap.get(Servo.class,"servo");



        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);


    }








}

