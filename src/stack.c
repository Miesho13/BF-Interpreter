#include "stack.h"

bracket_stack init_stack() {
    bracket_stack stack;
    stack.head = (int*)malloc(sizeof(int )*64);
    stack.sp = 0;
    stack.max_count = 64;
    return stack;
}

void stack_push(bracket_stack *bs, int val) {
    if (bs->sp == bs->max_count) {
        int *tmp = (int*)realloc(bs->head, bs->max_count << 2);
        bs->head = tmp;
    }
    bs->head[bs->sp++] = val;
}

int stack_get(bracket_stack *bs) {
    return bs->head[bs->sp - 1];
}

void stack_pop(bracket_stack *bs) {
    bs->sp--;
}
