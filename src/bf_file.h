#ifndef __BF_FILE__
#define __BF_FILE__

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <sys/stat.h>

typedef struct {
    uint8_t* buffer;
    size_t len;
} bf_file;

int is_file(const char *path);
long get_file_size(FILE* f);
bf_file open_file(const char* path);

#endif
