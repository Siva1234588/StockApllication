pipeline {
    agent any
    
    stages {
        stage('Clean stage') {
            steps {
            	dir("StockPricesApp"){
            		bat 'D:/13 Softwares/apache-maven-3.8.6-bin/apache-maven-3.8.6/bin/mvn -f D:/stocksapp/StockApllication/pom.xml clean'

            	
				}
            }
        }
        
        stage('Compile stage') {
            steps {
            dir("StockPricesApp"){
            		bat 'D:/13 Softwares/apache-maven-3.8.6-bin/apache-maven-3.8.6/bin/mvn -f D:/stocksapp/StockApllication/pom.xml compile'

            	
				}           
            }
        }
        
        stage('Install stage') {
            steps {
            dir("StockPricesApp"){
            		bat 'D:/13 Softwares/apache-maven-3.8.6-bin/apache-maven-3.8.6/bin/mvn -f D:/stocksapp/StockApllication/pom.xml install'

            	
				}           
            }
        }
    }
}

                    

 