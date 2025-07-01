#include "bf_file.h"

int is_file(const char *path) {
    struct stat st;
    return (stat(path, &st) == 0) && S_ISREG(st.st_mode);
}

long get_file_size(FILE* f) {
    fseek(f, 0, SEEK_END);
    long size = ftell(f);
    fseek(f, 0, SEEK_SET);
    return size;
}

bf_file open_file(const char* path) {
    bf_file bf = {0};
    if (!is_file(path)) {
        fprintf(stderr, "Error: Not a file.");
        return bf;
    }

    FILE* f = fopen(path, "r");
    if (!f) {
        fprintf(stderr, "Error: File can't be open.");
        return bf;
    }

    long size = get_file_size(f);
    if (size <= 0) {
        fprintf(stderr, "Error: file cant be 0 file");
        return bf;
    }
    
    bf.buffer = (uint8_t*)malloc(size + 1);
    bf.buffer[size] = 0;

    fread(bf.buffer, 1, size, f);
    fclose(f);
    bf.len = size;
    return bf;
}

