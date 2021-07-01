"# LLD-LoggerApp" 
Create a logger library similar to Slf4j or Logback 

Requirements :
- Should support different logging levels.
- Provide feature to support multiple Sinker source. 
- Sinker are destinations where logs are written.
- Sinker could be File/Console/DB 
- Difference LogLevels could be redirected to different Sinkers simultaneously.
- Library should be configured with Configuration.
- Configuration can be of time key - value pair.
- Log should be formatted with current time and Class Name as prefix for message being logged.
- Current Logging level should be defined as Configuration.

