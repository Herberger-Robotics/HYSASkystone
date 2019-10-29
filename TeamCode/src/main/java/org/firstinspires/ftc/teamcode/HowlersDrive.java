/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="HowlersDrive", group="Iterative Opmode")

public class HowlersDrive extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    HowlersHardware robot = new HowlersHardware();



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
        Claw();
        Strafe(1);
        Move(1);



    }

    public void Claw()
    {
        if(gamepad2.left_bumper){
           robot.liftClaw.setPower(-0.9);
        } else if (gamepad2.right_bumper){
            robot.liftClaw.setPower(0.9);
        } else {
            robot.liftClaw.setPower(0);
        }


        if(gamepad2.a){
            robot.leftClaw.setPosition(0.2);
            robot.rightClaw.setPosition(0.2);

        }else if (gamepad2.b){
            robot.leftClaw.setPosition(0);
            robot.rightClaw.setPosition(0);
        }
        if(gamepad2.dpad_up) {
            encoderLift(1, 1);
        }




    }
    public void encoderLift(double speed, double rotations){
        int liftTarget;
            liftTarget = robot.rightFront.getCurrentPosition() + (int)(rotations) * (1440);

            robot.liftClaw.setTargetPosition(liftTarget);

            robot.liftClaw.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.liftClaw.setPower(speed);

            while (robot.liftClaw.isBusy())
            {

            }

            robot.liftClaw.setPower(0);

            robot.liftClaw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }

    public void Move(double speed){
        double y = 0;
        double x = 0;
        double leftPower = 0;
        double rightPower = 0;
        x = speed * gamepad1.left_stick_x;
        y = speed * gamepad1.left_stick_y;
        leftPower = y+x;
        rightPower = y-x;
        robot.leftFront.setPower(y-x);
        robot.leftBack.setPower(y+x);

        robot.rightFront.setPower(y-x);
        robot.rightBack.setPower(y+x);

    }


    public void Strafe(double speed){

        if (gamepad1.right_bumper) {
            robot.leftFront.setPower(speed);
            robot.leftBack.setPower(-speed);

            robot.rightFront.setPower(-speed);
            robot.rightBack.setPower(speed);

        }else if (gamepad1.left_bumper){
            robot.leftFront.setPower(-speed);
            robot.leftBack.setPower(speed);

            robot.rightFront.setPower(speed);
            robot.rightBack.setPower(-speed);
        }






    }
    /*public void leftStrafe(){
        double speed = 0;
        if(gamepad1.left_bumper) {
            speed = 1;
        }
        robot.leftFront.setPower(-speed);
        robot.leftBack.setPower(speed);

        robot.rightFront.setPower(speed);
        robot.rightBack.setPower(-speed);
        /*else{
            robot.rightBack.setPower(0); // breaks motors
            robot.rightFront.setPower(0);
            robot.leftFront.setPower(0);
            robot.leftBack.setPower(0);

        }


    }*/



    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        robot.rightBack.setPower(0);
        robot.rightFront.setPower(0);
        robot.leftBack.setPower(0);
        robot.leftFront.setPower(0);
        robot.liftClaw.setPower(0);
    }


}