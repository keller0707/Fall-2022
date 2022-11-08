function sub1(){
    var x;
    function sub2(){
        console.log("X: " + x); // Creates a dialog box with the value of x
    }; // End sub2

    function sub3(){
        var x;
        x = 3;
        sub4(sub2);
    }; // End sub3

    function sub4(subx){
        var x;
        x = 4;
        subx();
    }; // End sub4

    x = 1;
    sub3();
};// End sub1

// Call Function
sub1();