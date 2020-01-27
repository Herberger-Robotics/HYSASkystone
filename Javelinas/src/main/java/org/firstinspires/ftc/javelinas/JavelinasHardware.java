package org.firstinspires.ftc.javelinas;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class JavelinasHardware {
    public DcMotor rightFront = null;
    public DcMotor rightRear = null;
    public DcMotor leftFront = null;
    public DcMotor leftRear = null;
    public DcMotor rotor1 = null;
    public DcMotor rotor2 = null;
    public CRServo extendArm = null;
    public DcMotor lift = null;
    public Servo servo =null;
    public Servo theservo = null;

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
        theservo = hwMap.get(Servo.class, "theservo");
        rotor1 = hwMap.get(DcMotor.class,"rotor1");
        rotor2 = hwMap.get(DcMotor.class,"rotor2");




        rotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        rotor2.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.FORWARD);
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);


    }








}

