# Fantasy Football App

An application for tracking:
*    Weekly Power Rankings
*    Past Champions
*    Historical Stats

This application was created because these pieces are either missing from ESPN's fantasy application(s) or deliver poor user experience.

# Environment Setup
## Program Arguments
For production use: `--spring.profiles.active=prod`

For non-production use: `--spring.profiles.active=dev`

## JVM
Since this applicatin is running on Heroku, the current JVM arguments are `-Xmx350m -Xss512k`. Use this when running the application in non-production environments as well.