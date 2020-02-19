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

package org.firstinspires.ftc.howlers;

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
    double gear = 1;



    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robot.init(hardwareMap);


        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
        gear = 1;

        robot.liftClaw.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.footLong.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        robot.capstone.setPosition(0.2);

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
        Park();
        capstonePoop();
        //Strafe(1);

        double speed = 0.25 * gear;

        double y =0;
        double x =0;
        y = gamepad1.left_stick_y;
        x = gamepad1.left_stick_x;

            robot.leftFront.setPower((y - x) * speed);
            robot.leftBack.setPower((y - x) * speed);

            robot.rightFront.setPower((y + x) * speed);
            robot.rightBack.setPower((y + x) * speed);


       if (gamepad1.right_bumper) {
            robot.leftFront.setPower(-0.25 * gear);
            robot.leftBack.setPower(0.25 * gear);

            robot.rightFront.setPower(0.25 * gear);
            robot.rightBack.setPower(-0.25 * gear);

        }else if (gamepad1.left_bumper){
            robot.leftFront.setPower(0.25 * gear);
            robot.leftBack.setPower(-0.25 * gear);

            robot.rightFront.setPower(-0.25 * gear);
            robot.rightBack.setPower(0.25 * gear);
        }
        if (gamepad1.a) {
            gear = 2;
        }else if(gamepad1.b) {
            gear = 1;
        }else if(gamepad1.y) {
            gear = 3;
        }else if(gamepad1.x) {
            gear = 4;
        }

    }

    public void Claw() {
        if (gamepad2.right_bumper) {
            robot.liftClaw.setPower(-1);
        } else if (gamepad2.left_bumper) {
            robot.liftClaw.setPower(1);
        } else {
            robot.liftClaw.setPower(0);
        }


        if (gamepad2.a) {
            robot.clawServo.setPosition(0.5);

        } else if (gamepad2.b) {
            robot.clawServo.setPosition(0.1);
        }

    }

    public void Park() {
        if(gamepad2.x) {
            robot.footLong.setPower(1);
        } else if(gamepad2.y){
            robot.footLong.setPower(-1);
        } else {
            robot.footLong.setPower(0);
        }
    }

    public void capstonePoop(){
        if (gamepad1.dpad_down) {
            robot.capstone.setPosition(0.7);
        }

        if(gamepad1.dpad_up){
            robot.capstone.setPosition(0.2);
        }


    }

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