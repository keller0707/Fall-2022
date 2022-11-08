!
! Name        : Keller Sedillo-Garrido
! Date        : September 28, 2022
! Description : This program will perform Gaussian Elimination and Backward Subitution
!             : with a NxN+1 Matrix
! Input       : The size of the matrix
! Output      : A solved matrix with solutions.
!
program gaussian
  implicit none
  
  ! Set Vars
  integer N, i, j, k                     ! Integers 
  real ratio                             ! Real Nums
  real, dimension(:,:), allocatable :: A ! 2-D Array for Matrix
  real, dimension(:), allocatable :: x   ! 1-D Array for Solutions
  character(100) :: input                ! User Input

  ! Read in Command Arg
  call GET_COMMAND_ARGUMENT(1, input) ! Get input from users
  read(input,*)N                      ! Set input as N

  !Allocate Space
  ALLOCATE(A(N ,N+1)) ! Allocate for Matrix
  ALLOCATE(x(N))      ! Allocate for Solutions

  !Randomizes Number
  call random_number(A)             ! Give array random numbers
  do i = 1, N                       ! Loop through row
    do j = 1, N+1                   ! Loop through col
      A(i,j) = 1 + FLOOR(10*A(i,j)) ! Set Whole numbers
    end do                          ! End for
  end do                            ! End for 

  
  !Gaussian Elimination
  do i = 1, N                             ! Loop through col
    if ( A(i,i) == 0 ) then               ! Check if diag = 0
      A(i,i) = 1                          ! Set it to 1
    end if                                ! End if
    do j = i+1, N                         ! Loop through row
      ratio = A(j,i)/A(i,i)               ! Set ratio
      do k = 1, N+1                       ! Loop through row
        A(j,k) = A(j, k) - ratio * A(i,k) ! Update elements
      end do                              ! End for
    end do                                ! End for
  end do                                  ! End for
  
  !Backward Sub.
  x(N) = A(N,N+1)/A(N,N)        ! Set init. Solution
  do i = N-1, 1, -1             ! Loop backwards from Solution array
    x(i) = A(i,N)               ! Set Elements
    do j = i+1, N               ! Loop through col
      x(i) = x(i) - A(i,j)*x(j) ! Update Elements
    end do                      ! End for
    x(i) = x(i)/A(i,i)          ! Update solution
  end do                        ! End for
  
end program gaussian
