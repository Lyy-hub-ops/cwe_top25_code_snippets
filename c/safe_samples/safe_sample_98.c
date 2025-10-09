/* Safe memory management */
#include <stdio.h>
#include <stdlib.h>

void* safe_malloc(size_t size) {
    if (size == 0) {
        return NULL;
    }
    
    void* ptr = malloc(size);
    if (ptr == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(1);
    }
    
    return ptr;
}

void safe_free(void** ptr) {
    if (ptr && *ptr) {
        free(*ptr);
        *ptr = NULL;
    }
}

int main() {
    char* buffer = (char*)safe_malloc(100);
    // Use buffer safely
    safe_free((void**)&buffer);
    return 0;
}
