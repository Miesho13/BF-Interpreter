#include <stdio.h>

long get_file_size(FILE* f) {
    fseek(f, 0, SEEK_END);
    long size = ftell(f);
    fseek(f, 0, SEEK_SET);
    return size;
}

void open_file(const char* path) {
    FILE* f = fopen(path, "r");
    
}

int main() {
        


    return 0;
}
