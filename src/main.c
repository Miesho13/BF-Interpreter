#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

long get_file_size(FILE* f) {
    fseek(f, 0, SEEK_END);
    long size = ftell(f);
    fseek(f, 0, SEEK_SET);
    return size;
}

uint8_t* open_file(const char* path) {
    FILE* f = fopen(path, "r");
    long size = get_file_size(f);
    uint8_t *bf_file = (uint8_t*)malloc(size + 1);
    bf_file[size] = 0;
    fread(bf_file, 1, size, f);
    fclose(f);
    return bf_file;
}

int main(int argc, char **argv) {
    if (argc != 2) {
        printf("Error: Invalid argumetn value\n\tUsage: bf [file name]\n");
        return 1;
    }
    open_file(argv[1]);
    
    return 0;
}
