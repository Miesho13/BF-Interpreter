#ifndef __STACK__
#define __STACK__

#include <stdlib.h>

typedef struct {
    int *head;
    int sp;
    int max_count;
} bracket_stack;

bracket_stack init_stack();
void stack_push(bracket_stack *bs, int val);
int stack_get(bracket_stack *bs);
void stack_pop(bracket_stack *bs);

#endif
