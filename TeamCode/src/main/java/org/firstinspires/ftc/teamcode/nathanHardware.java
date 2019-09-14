package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class nathanHardware {
    public DcMotor rightFrontDRIVE = null;
    public DcMotor rightRearDRIVE = null;
    public DcMotor leftFrontDRIVE = null;
    public DcMotor leftRearDRIVE = null;
    public DcMotor rotorIntake = null;
    public DcMotor armActuator = null;
    public Servo clawDropper = null;

    HardwareMap hwMap = null;

    public nathanHardware(){


    }

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        rightFrontDRIVE = hwMap.get(DcMotor.class, "rightFront");
        rightRearDRIVE = hwMap.get(DcMotor.class, "rightRear");
        leftFrontDRIVE = hwMap.get(DcMotor.class, "leftFront");
        leftRearDRIVE = hwMap.get(DcMotor.class, "leftRear");
        rotorIntake = hwMap.get(DcMotor.class, "rotorIntake");
        armActuator = hwMap.get(DcMotor.class, "armActuator");
        clawDropper = hwMap.get(Servo.class, "clawDropper");

        rightFrontDRIVE.setPower(0);
        rightRearDRIVE.setPower(0);
        leftFrontDRIVE.setPower(0);
        leftRearDRIVE.setPower(0);
        rotorIntake.setPower(0);
        armActuator.setPower(0);

        rightFrontDRIVE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRearDRIVE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFrontDRIVE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftRearDRIVE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }








}
