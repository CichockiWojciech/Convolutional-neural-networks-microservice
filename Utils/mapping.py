def get_job(sample):
    if sample == 'management':
        return 1;
    elif sample == 'technician':
        return 2;
    elif sample == 'entrepreneur':
        return 3;
    elif sample == 'retired':
        return 4;
    elif sample == 'admin':
        return 5;
    elif sample == 'blue-collar':
        return 6;
    elif sample == 'self-employed':
        return 7;
    elif sample == 'unemployed':
        return 8;
    else:
        return 0

def get_education(sample):
    if sample == 'primary':
        return 1;
    elif sample == 'secondary':
        return 2;
    elif sample == 'tertiary':
        return 3;
    elif sample == 'retired':
        return 4;
    elif sample == 'unknown':
        return 5;
    else:
        return 0
def get_housing(sample):
    if sample == 'yes':
        return 1;
    elif sample == 'no':
        return 0;
    else:
        return -99
def get_loan(sample):
    if sample == 'yes':
        return 1;
    elif sample == 'no':
        return 0;
    else:
        return -99
def get_month(sample):
    if sample == 'may':
        return 1;
    elif sample == 'jul':
        return 2;
    elif sample == 'aug':
        return 3;
    elif sample == 'jun':
        return 4;
    elif sample == 'nov':
        return 5;
    elif sample == 'apr':
        return 6;
    elif sample == 'feb':
        return 7;
    elif sample == 'jan':
        return 8;
    elif sample == 'oct':
        return 9
    else:
        return 0
def get_contact(sample):
    if sample == 'cellular':
        return 1;
    elif sample == 'telephone':
        return 0;
    else:
        return -99
def get_martial(sample):
    if sample == 'married':
        return 1;
    elif sample == 'single':
        return 0;
    elif sample == 'divorced':
        return 2;
    else:
        return -99
def get_defoult(sample):
    if sample == 'no':
        return 1;
    elif sample == 'tes':
        return 0;
    else:
        return -99
