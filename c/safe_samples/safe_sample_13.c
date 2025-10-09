/* Safe C code example */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int safe_string_copy(char* dest, const char* src, size_t dest_size) {
    if (dest == NULL || src == NULL || dest_size == 0) {
        return -1;
    }
    
    strncpy(dest, src, dest_size - 1);
    dest[dest_size - 1] = '\0';
    
    return 0;
}

int main() {
    char buffer[100];
    const char* input = "Safe input string";
    
    if (safe_string_copy(buffer, input, sizeof(buffer)) == 0) {
        printf("Safely copied: %s\n", buffer);
    }
    
    return 0;
}
