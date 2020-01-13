package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="JavelinasDrive", group="Iterative Opmode")
@Disabled
public class JavelinasDrive extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    JavelinasHardware robot = new JavelinasHardware();




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
        Move(1);
        liftBot();

        if(gamepad2.a){
        grabClaw();
        }

        if(gamepad2.b){
            openClaw();
        }



        if(gamepad1.right_bumper){
            leftStrafe(1);
        }
        if(gamepad1.left_bumper){
            rightStrafe(1);
        }

        /*if(gamepad2.a){
            robot.extendArm.setPower(1);

        } else if(gamepad2.b) {
            robot.extendArm.setPower(-1);
        }else{
            robot.extendArm.setPower(0);

        }*/


    }


    public void Move(double speed){
        double y = 0;
        double x =0;

        x = gamepad1.left_stick_x * speed;
        y = gamepad1.left_stick_y * speed;

        robot.leftRear.setPower(y-x);
        robot.leftFront.setPower(y-x);

        robot.rightRear.setPower(y+x);
        robot.rightFront.setPower(y+x);
    }

    public void liftBot(){

        if(gamepad2.right_bumper){
            robot.lift.setPower(-1);
        }else if(gamepad2.left_bumper){
            robot.lift.setPower(1);
        }else{
            robot.lift.setPower(0);

        }

    }
    public void grabClaw(){
            robot.servo.setPosition(0.20);

    }





    public void rightStrafe(double speed){

        robot.leftFront.setPower(-speed);
        robot.leftRear.setPower(speed);
        robot.rightFront.setPower(speed);
        robot.rightRear.setPower(-speed);

    }

    public void leftStrafe(double speed){

        robot.leftFront.setPower(speed);
        robot.leftRear.setPower(-speed);
        robot.rightFront.setPower(-speed);
        robot.rightRear.setPower(speed);

    }

    public void openClaw(){

        robot.servo.setPosition(0);


    }



    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {



    }


}
