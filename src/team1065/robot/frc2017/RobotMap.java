package team1065.robot.frc2017;

public class RobotMap {
	
	//PID Constants
    public static final double STRAIGHT_DRIVE_P = 1/20,
    		                   MECANUM_STRAIGHT_DRIVE_P = 1/20;
    
    //Shooter RPM values
    public static final double SHOOTER_RPM_0 = 0.0,
    						   SHOOTER_RPM_1 = 5600.0,
    						   SHOOTER_RPM_2 = 5700.0,
    						   SHOOTER_RPM_3 = 5800.0,
    						   SHOOTER_RPM_4 = 5850.0,
    						   SHOOTER_RPM_5 = 5900.0;
    
    //Shooter Voltage values
    public static final double SHOOTER_VOLT_0 = 0.0,
    						   SHOOTER_VOLT_1 = 0.6,
    						   SHOOTER_VOLT_2 = 0.7,
    						   SHOOTER_VOLT_3 = 0.8,
    						   SHOOTER_VOLT_4 = 0.9,
    						   SHOOTER_VOLT_5 = 1.0;
    
    //Double Constants
    public static final double JOYSTICK_DEADBAND = 0.05;
	
	//PWM Ports
    public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0,
    				  	    RIGHT_FRONT_DRIVE_MOTOR_PORT = 1,
		  	    			LEFT_BACK_DRIVE_MOTOR_PORT = 2,
    				  	    RIGHT_BACK_DRIVE_MOTOR_PORT = 3;
    //OI
    //TODO: change names to match this year's usage
    public static final int LEFT_JOYSTICK_PORT = 0,
					  		RIGHT_JOYSTICK_PORT = 1,
					  		ENHANCED_DS_PORT = 2,
					  		DRIVE_CONTROL_OVERRIDE = 2,//Digital
						    INTAKE_IN_PORT = 4,//Digital
						    INTAKE_OUT_PORT = 5,//Digital
						    SHOOTER_CONTROLLER_OVERRIDE = 9,//Digital
						    OBSTACLE_MANIPULATOR_SWITCH_PORT = 1,//digital
						    SHOOTER_LONG_DISTANCE_SWITCH_PORT = 12,//digital
				    		SHOOTER_KNOB_PORT = 0,//Analog
				    		AUTO_KNOB_PORT = 1;//Analog
}
