import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-quiz',
  templateUrl: './update-quiz.component.html',
  styleUrls: ['./update-quiz.component.css']
})
export class UpdateQuizComponent implements OnInit {

  qId = 0;
  quiz: any;
  categories: any;

  constructor(private _route: ActivatedRoute,
    private _quiz: QuizService,
    private _cat: CategoryService,
    private __router: Router) { }

  ngOnInit(): void {
    this.qId = this._route.snapshot.params.qid;
    // alert(this.qId);
    this._quiz.getQuiz(this.qId).subscribe(
      (data: any) => {
        this.quiz = data;
        console.log(this.quiz);
      },
      (error) => {
        console.log(error);
      }
    );

    this._cat.categories().subscribe((data: any) => {
      this.categories = data;
    },
      (error) => {
        alert("Error in loading categories");
      }
    );
  }

  //update form submit
  public updateQuiz() {
    //alert("Update");
    //validate data
    this._quiz.updateQuiz(this.quiz).subscribe(
      (data: any) => {
        Swal.fire("Success !!!", "Quiz Updated", "success").then((e) => {
          this.__router.navigate(['/admin/quizzes']);
        });
      },
      (error) => {
        Swal.fire("Error !!!", "Error in updating", 'error');
        console.log(error);
      }
    );
  }

}
