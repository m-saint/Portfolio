#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct job {
    int id;
    int length;
    struct job* next;
    int response;
    int turnaround;
    int wait;
};

void fifo(struct job* first){ // just print them out in order

    // policy implementation (uncomment print statements to pass policy tests)

    struct job* this = first;
    int response = 0;
    //printf("Execution trace with FIFO:\n");
    while(this != NULL){
        this->response = response; // fill in metrics that were updated after last job
        this->turnaround = this->response + this->length;
        this->wait = this->response;
        //printf("Job %d ran for: %d\n", this->id, this->length);
        response += this->length; // keep adding to the total response time
        this = this->next;
    }
    //printf("End of execution with FIFO.\n");

    // analysis (comment out print statements to pass policy tests)

    this = first;
    double r = 0; // stuff for calculating avgs
    double t = 0;
    double w = 0;
    int count = 0;
    printf("Begin analyzing FIFO:\n");
    while(this != NULL){
        count++;
        printf("Job %d -- Response time: %d  Turnaround: %d  Wait: %d\n", this->id, this->response, this->turnaround, this->wait);
        r += this->response;
        t += this->turnaround;
        w += this->wait;
        this = this->next;
    }
    printf("Average -- Response: %.2f  Turnaround: %.2f  Wait: %.2f\n", r/count, t/count, w/count);
    printf("End analyzing FIFO.\n");
}

void sjf(struct job* first) {

    // re-order list

    int numSwaps; // if we make it through the list with no swaps, we're done
    struct job* this;

    while (numSwaps > 0) { // we had to swap last iteration
        numSwaps = 0;
        this = first;

        while (this->next != NULL) { // run through the linked list
            if (this->length > this->next->length) { // jobs are out of order, switch em
                int tempId = this->id;
                int tempLength = this->length;
                this->id = this->next->id;
                this->length = this->next->length;
                this->next->id = tempId;
                this->next->length = tempLength;
                numSwaps++;
            }
            this = this->next; // next job
        }
    }

    // output policy implementation (uncomment print statements to pass policy tests)    

    this = first;
    int response = 0;
    //printf("Execution trace with SJF:\n");
    while(this != NULL){
        this->response = response; // fill in metrics that were updated after last job
        this->turnaround = this->response + this->length;
        this->wait = this->response;
        //printf("Job %d ran for: %d\n", this->id, this->length);
        response += this->length; // keep adding to the total response time
        this = this->next;
    }
    //printf("End of execution with SJF.\n");

    // analysis (comment out print statements to pass policy tests)

    this = first;
    double r = 0; // stuff for calculating avgs
    double t = 0;
    double w = 0;
    int count = 0;
    printf("Begin analyzing SJF:\n");
    while(this != NULL){
        count++;
        printf("Job %d -- Response time: %d  Turnaround: %d  Wait: %d\n", this->id, this->response, this->turnaround, this->wait);
        r += this->response;
        t += this->turnaround;
        w += this->wait;
        this = this->next;
    }
    printf("Average -- Response: %.2f  Turnaround: %.2f  Wait: %.2f\n", r/count, t/count, w/count);
    printf("End analyzing SJF.\n");
}

void rr(struct job* first, int tSlice){

    // policy implementation (uncomment print statements to pass policy tests)

    struct job* this = first;
    //printf("Execution trace with RR:\n");
    int timeLeft = 99;
    int wait = 0;
    while (timeLeft > 0){ // there is at least one job that needs to finish
        this = first;
        timeLeft = 0;
        while(this != NULL){ // run through the list, run the jobs for tSlice, decrease their remaining time, update time left
            
            if (this->response == 999){ // first time a job is run
                this->response = wait;
            }

            if (this->length > tSlice){ // this job won't finish in this slice
                //printf("Job %d ran for: %d\n", this->id, tSlice);
                wait += tSlice;
                this->wait -= tSlice; // wait doesn't count the job's own run time
                this->length -= tSlice;
                timeLeft += this->length;
            }
            else if (this->length <= tSlice && this->length != 0){ // job will finish
                //printf("Job %d ran for: %d\n", this->id, this->length);
                wait += this->length;
                this->wait -= this->length; // wait doesn't count the job's own run time
                this->turnaround = wait;
                this->wait += this->turnaround; // wait is turnaround - run time
                this->length = 0;
            }
            this = this->next;
        }
    }
    //printf("End of execution with RR.\n");

    // analysis (comment out print statements to pass policy tests)

    this = first;
    double r = 0; // stuff for calculating avgs
    double t = 0;
    double w = 0;
    int count = 0;
    printf("Begin analyzing RR:\n");
    while(this != NULL){
        count++;
        printf("Job %d -- Response time: %d  Turnaround: %d  Wait: %d\n", this->id, this->response, this->turnaround, this->wait);
        r += this->response;
        t += this->turnaround;
        w += this->wait;
        this = this->next;
    }
    printf("Average -- Response: %.2f  Turnaround: %.2f  Wait: %.2f\n", r/count, t/count, w/count);
    printf("End analyzing RR.\n");
}

int main(int argc, char* argv[]) {
    struct job* first = NULL; // first job in the list
    struct job* this = NULL; // currently examined job

    char* pol = argv[1]; // desired scheduling policy
    char* load = argv[2]; // workload file name
    char* tSlice = argv[3]; // time slice for RR
    int slice = atoi(tSlice);

    // read workload file line by line

    char line[99];

    FILE* in;

    in = fopen(load, "r");

    int i = 0;
    while (fgets(line, sizeof(line), in)) {

        // create a job and fill in its info
        struct job* j = malloc(sizeof(struct job));
        j->id = i;
        j->length = atoi(line);
        j->next = NULL;
        j->response = 999;

        // add job to linkedlist
        if (first == NULL) {
            first = j;
            this = j;
        } else {
            this->next = j; // previous job points to this job
            this = j; // update job
        }
        i++;
    }
    fclose(in);

    if (strcmp(pol, "FIFO") == 0){
        fifo(first);
    } else if (strcmp(pol, "SJF") == 0){
        sjf(first);
    } else if (strcmp(pol, "RR") == 0){
        rr(first, slice);
    } else {
        printf("invalid policy\n");
    }

    return 0;
}
