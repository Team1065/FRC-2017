package team1065.robot.frc2017;

public class RobotMap {
	
	//PID Constants
    public static final double STRAIGHT_DRIVE_P = 0.052,
    		                   MECANUM_STRAIGHT_DRIVE_P = 0.052,
    		                   SHOOTER_F = 1.68,//1.5345 test bench
	                		   SHOOTER_P = 13,//.5 testbench
            				   SHOOTER_I = 0.0001,//0.001 testbench
    						   SHOOTER_D = 0;
    
    //Shooter RPM values
    public static final double SHOOTER_RPM_0 = 0.0,
    						   SHOOTER_RPM_1 = 1750.0,
    						   SHOOTER_RPM_2 = 1800.0,
    						   SHOOTER_RPM_3 = 1850.0,
    						   SHOOTER_RPM_4 = 1900.0,
    						   SHOOTER_RPM_5 = 1950.0;
    
    //Shooter Voltage values
    public static final double SHOOTER_VOLT_0 = 0.0,
    						   SHOOTER_VOLT_1 = 0.45,
    						   SHOOTER_VOLT_2 = 0.50,
    						   SHOOTER_VOLT_3 = 0.55,
    						   SHOOTER_VOLT_4 = 0.6,
    						   SHOOTER_VOLT_5 = 1.0;
    
    //Double Constants
    public static final double JOYSTICK_DEADBAND = 0.05,
			                   DRIVE_STRAIGHT_BAND_PERCENTAGE = 0.2,
	    					   DRIVE_WHEEL_DIAMETER = 6,
							   DRIVE_ENCODERS_COUNTS_PER_REV = 20;
	
	//PWM Ports
    public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0,
    				  	    RIGHT_FRONT_DRIVE_MOTOR_PORT = 1,
		  	    			LEFT_BACK_DRIVE_MOTOR_PORT = 2,
    				  	    RIGHT_BACK_DRIVE_MOTOR_PORT = 3,
    				  	    INTAKE_MOTOR_PORT = 4,
    				  	    AGITATOR_MOTOR_PORT = 5,
    				  	    CLIMBER_MOTOR_PORT = 6;
    
    //PCM Ports
    public static final int INDEXER_SOLENOID_PORT = 0,
    						GEAR_INTAKE_SOLENOID_PORT = 1,
    						GEAR_PUSHER_SOLENOID_PORT = 2,
    						DROPDOWN_SOLENOID_PORT = 3;
    
    //Digital Ports
    public static final int DRIVE_ENCODER_PORT_A = 0,
	    				    DRIVE_ENCODER_PORT_B = 1;
    
    //CANTalon Ports
    public static final int MASTER_TALON_PORT = 1,
    						SLAVE_TALON_PORT = 2;
    
    //OI
    public static final int LEFT_JOYSTICK_PORT = 0,					//usb
					  		RIGHT_JOYSTICK_PORT = 1,				//usb
				  			ENHANCED_DS_PORT = 2,					//usb
					  		GEAR_INTAKE_CLOSE_SWITCH_PORT = 1,	    //digital
					  		COMPRESSOR_CONTROL_OVERRIDE = 2,		//Digital
						    INTAKE_IN_PORT = 4,						//Digital
						    INTAKE_OUT_PORT = 5,					//Digital
						    CLIMB_UP_PORT = 6,						//Digital
						    CLIMB_DOWN_PORT = 8,					//Digital
						    SHOOTER_CONTROLLER_OVERRIDE = 9,		//Digital
						    SHOOTER_LONG_DISTANCE_SWITCH_PORT = 12,	//digital
				    		SHOOTER_KNOB_PORT = 0,					//Analog
				    		AUTO_KNOB_PORT = 1;						//Analog
    
    public static final double SHOOTER_KNOB_POS_0 = 0.000,
			   SHOOTER_KNOB_POS_1 = 0.024,
			   SHOOTER_KNOB_POS_2 = 0.047,
			   SHOOTER_KNOB_POS_3 = 0.071,
			   SHOOTER_KNOB_POS_4 = 0.094,
			   SHOOTER_KNOB_POS_5 = 0.118,
			   AUTO_KNOB_POS_0 = 0.000,
			   AUTO_KNOB_POS_1 = 0.024,
			   AUTO_KNOB_POS_2 = 0.055,
			   AUTO_KNOB_POS_3 = 0.087;
}
