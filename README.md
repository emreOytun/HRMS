# HRMS-BackEnd
A back-end system for Human Resource Management.

# Requirements PART - 1 : (DONE)

IMPORTANT 1 : Create fake services for authentication processes e.g. No need to send mail really.

IMPORTANT 2 : Don't code except requirements. This is an inconvenient software developer acting for Project Management and ALM(Application LifeCycle Management).

<b> Req 1 : Candidates can sign up the system. </b>

Acceptance Criterias : <br>
-> First name, last name, identity number, birth year, email, password informations are needed to be filled by user while signing up. <br>
-> All fields are must. User gets informed. <br>
-> Signing up is done after Mernis Authentication. <br>
-> User gets informed if the authentication is not valid. <br>
-> User cannot sign up with email or identity number which are registered before. User gets informed. <br>
-> Email verification is needed after signing up.

<b> Req 2 : Employers can sign up the system. </b>

Acceptance Criterias : <br>
-> Company name, web address, email with the same domain as web address, phone, password are needed to be filled by user while signing up. <br>
-> All fields are must. User gets informed. <br>
-> Company registers are verified with two ways. Email verification is needed after signing up and HRSM Employee should confirm employer. <br>
-> Signing up cannot be done with an email which is registered before. <br>

<b> Req 3 : Job Titles can be added to the system e.g. Software Developer, Software Architect. </b>

Acceptance Criterias : <br>
-> Same title cannot be added. User gets informed.

<b> Req 4 : Employers can be listed. (Only all list) </b>

<b> Req 5 : Candidates can be listed. (Only all list) </b>

<b> Req 6 : Job Titles can be listed. (Only all list) </b>
