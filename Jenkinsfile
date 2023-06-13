pipeline {
    agent any

    //Se define el archivo para realizar los escaneos de SonarQube
    //De preferencia es una configuracion realizada en Jenkins
    environment {
        scannerHome=tool "sonarqube-scanner"
    }

    //Se define la version que se utilizara de Maven para construir el proyecto
    //De preferencia es una configuracion realizada en Jenkins
    tools {
        maven "jenkins-maven"
    }

    //Se definen todos los pasos que realizara el pipeline al momento de su ejecucion
    stages {
        //Paso en el cual se mostrara en consola la version de maven y de java
        stage('Tool Settings') {
            steps {
                sh "mvn -version"
            }
        }

        //Paso que realiza la construccion del proyecto limpiando previamente las
        //carpeta de construcciones pasadas, saltandose la ejecucion de Tests
        stage('Build Project') {
            steps {
                sh "mvn -B -DskipTests clean package"
            }
        }

        //Paso que realiza la ejecucion de los Test del proyecto
        stage('Run Tests'){
            steps {
                sh "mvn test"
            }
        }

        //Paso donde se realiza el escaneo del proyecto con SonarQube
        //Las propiedades para realizar el analisis las toma del archivo sonar-project.properties
        stage('Analyzing Code with SonarQube') {
            steps {
                withSonarQubeEnv("sonarqube-container") {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
            }
        }

        //Paso donde almacenara de forma temporal en Jenkins los artefactos
        //que se encuentran en todas las carpetas target del proyecto
        stage('Save Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
}
