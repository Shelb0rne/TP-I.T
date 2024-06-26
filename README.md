# TP-I.T (Цуркан Игорь 233)

## ТЗ №1 
### Описание работы скрипта.
Скрипт получает на вход две директории (```input_dir``` и ```output_dir```). После запуска скрипта все файли из директории ```input_dir``` и из внутренних директорий ```input_dir``` будут скопированы в выходную директорию - ```output_dir```.
Для запуска скрипта следует использовать команду:
```
sh CopyFiles.sh <Входная директория> <Выходная директория>
```
### Как работает скрипт?
1. Проверка количества переданных аргументов:

  - ```if [ $# -ne 2 ]; then``` - проверяет количество аргументов, переданных при запуске скрипта. Если их количество не равно 2, выводится сообщение о том, что необходимо указать входную и выходную директории и скрипт завершает свою работу с кодом 1.

2. Определение входной и выходной директорий:

  - ```input_dir="$1"``` - присваивает первый переданный аргумент скрипту (входную директорию) переменной ```input_dir```.
  - ```output_dir="$2"``` - присваивает второй переданный аргумент скрипту (выходную директорию) переменной ```output_dir```.

3. Создание выходной директории:

  - ```mkdir -p "$output_dir"``` - создает выходную директорию, включая несуществующие родительские директории, если они не существуют.

4. Получение списка файлов во входной директории:

  - ```file_list=$(find "$input_dir" -type f)``` - получает список всех файлов во входной директории и сохраняет их в переменной ```file_list```.

5. Копирование файлов из входной в выходную директорию:

  - ```for file_path in $file_list; do``` - перебирает все файлы из списка ```file_list```.
  - ```file_name=$(basename "$file_path")``` - получает имя файла из его пути.
  - ```if [ -e "$output_dir/$file_name" ]; then``` - проверяет, существует ли файл с таким же именем в выходной директории. Если да, добавляет к имени файла текущую метку времени.
  - ```cp "$file_path" "$output_dir/$file_name"``` - копирует файл из входной директории в выходную директорию с учетом измененного имени файла.

6. Завершение работы скрипта:

  - ```echo "Скопировано"``` - выводит сообщение о том, что файлы были скопированы успешно.
Таким образом, данный скрипт копирует все файлы из указанной входной директории в указанную выходную директорию, при необходимости изменяя их имена.
