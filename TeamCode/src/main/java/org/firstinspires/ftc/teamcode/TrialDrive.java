package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@TeleOp(name="TrialDrive", group="Iterative Opmode")

public class TrialDrive extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    TrialHardware robot = new TrialHardware();
    boolean z;


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robot.init(hardwareMap);


        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        if(gamepad1.b){
            boolean z = true;
        }else if(gamepad1.y){
            boolean z = false;
        }

        if(z = true){
            Move(0.5);


        }else if(z = false){
            Move(1);

        }

        claw();







    }

    public void claw(){

        if(gamepad2.right_bumper){
            robot.armActuator.setPower(0.5);


        }else{
            robot.armActuator.setPower(0);



        } if(gamepad2.left_bumper){
            robot.armActuator.setPower(-0.5);

        }
        if(gamepad2.a){

            robot.clawDropper.setPosition(180);

            if(gamepad2.x){

                robot.clawDropper.setPosition(360);

            }
        }




    }

    public void Move(double speed){
        double y = 0;
        double x =0;

        x = gamepad1.left_stick_x * speed;
        y = gamepad1.left_stick_y * speed;

        robot.leftRearDRIVE.setPower(y+x);
        robot.leftFrontDRIVE.setPower(y+x);

        robot.rightRearDRIVE.setPower(y-x);
        robot.rightFrontDRIVE.setPower(y-x);


    }





    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {



    }


}
