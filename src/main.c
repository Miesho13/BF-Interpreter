#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <sys/stat.h>

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

uint8_t* open_file(const char* path) {
    if (!is_file(path)) {
        fprintf(stderr, "Error: Not a file.");
        return NULL;
    }

    FILE* f = fopen(path, "r");
    if (!f) {
        fprintf(stderr, "Error: File can't be open.");
        return NULL;
    }

    long size = get_file_size(f);
    if (size <= 0) {
        fprintf(stderr, "Error: file cant be 0 file");
        return NULL;
    }

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

    uint8_t* bf_content = open_file(argv[1]);
    if (!bf_content) {
        return 2;
    }
    
    return 0;
}
