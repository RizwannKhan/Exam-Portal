import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {

  categories: any = [];

  quizData = {
    title: '',
    description: '',
    maxMarks: '',
    numberOfQuestions: '',
    active: true,
    category: null,
  };

  constructor(private _category: CategoryService, private _snack: MatSnackBar, private _quiz: QuizService) { }

  ngOnInit(): void {
    this._category.categories().subscribe(
      (data: any) => {
        //categories load successfuly
        this.categories = data;
        //console.log(this.categories);
      },
      (error) => {
        //error occured
        console.log(error);
        Swal.fire('Error !!', 'Error in loading Categories from Server !!', 'error');
      }
    );
  }

  //add quiz
  public addQuiz() {
    //console.log(this.quizData);
    if (this.quizData.title.trim() == '' || this.quizData.title == null) {
      this._snack.open('Title Required !!', '', {
        duration: 3000,
      });
      return;
    }

    //validation...

    //call server...
    this._quiz.addQuiz(this.quizData).subscribe(
      (data: any) => {
        Swal.fire('Success !!', 'Quiz is added successfuly', 'success');
        this.quizData = {
          title: '',
          description: '',
          maxMarks: '',
          numberOfQuestions: '',
          active: true,
          category: null,
        };
      },
      (error: any)=>{
        Swal.fire('Error !!', 'Error while adding quiz', 'error');
        console.log(error);        
      }
    );
  }

}
