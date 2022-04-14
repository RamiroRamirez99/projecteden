/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;
import com.pi4j.component.motor.impl.GpioStepperMotorComponent;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
/**
 *
 * @author ramiroramirez
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
  public static void main(String[] args) throws InterruptedException {
      
       final GpioController gpio = GpioFactory.getInstance();
final GpioPinDigitalOutput[] pins = {
 gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW),
 gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW),
 gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW),
 gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW)};
      
GpioStepperMotorComponent motor = new GpioStepperMotorComponent(pins);

byte[] dhalf_step_sequence = new byte[8];
 dhalf_step_sequence[0] = (byte) 0b0001;
 dhalf_step_sequence[1] = (byte) 0b0011;
 dhalf_step_sequence[2] = (byte) 0b0010;
 dhalf_step_sequence[3] = (byte) 0b0110;
 dhalf_step_sequence[4] = (byte) 0b0100;
 dhalf_step_sequence[5] = (byte) 0b1100;
 dhalf_step_sequence[6] = (byte) 0b1000;
 dhalf_step_sequence[7] = (byte) 0b1001;
 
 motor.setStepInterval(0, 0000000001);

 motor.setStepSequence(dhalf_step_sequence);

 motor.setStepsPerRevolution(2038);
 
 motor.forward();
    }
  
  
}
