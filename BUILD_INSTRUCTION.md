# Инструкция по сборке
## Что понадобится ?
* Maven, поскольку он используется здесь в качестве системы сборки
* java версии не ниже 1.8
## Шаги сборки:
* склонируйте репозиторий себе с помощью git или скачайте архивом и распакуйте его
* в папке с проектом выполните следующие команды:
  * mvn dependency:resolve
  * mvn package
## Как запустить ?
К данному этапу необходимо приступать после выполнения предыдущего.

В папке _target_ в корневой папке проекта будет лежать два файла, нас интересует тот, который оканчивается на **-jar-with-dependencies.jar**

Для запуска выполните команду, находясь в корневой папке проекта: 
    
    java -jar target/ComplexCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar
Имя файла может отличаться для будущих версий