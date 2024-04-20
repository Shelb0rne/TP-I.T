#!/bin/bash
if [ $# -ne 2 ]; then
    echo "Необходимо два аргумента(входная и выходная директория): $0 <input_directory> <output_directory>"
    exit 1
fi

input_dir="$1"
output_dir="$2"

mkdir -p "$output_dir"
file_list=$(find "$input_dir" -type f)
for file_path in $file_list; do
    file_name=$(basename "$file_path")
    if [ -e "$output_dir/$file_name" ]; then
        file_name="${file_name}_$(date +%s)"
    fi
    cp "$file_path" "$output_dir/$file_name"
done

echo "Скопировано"
