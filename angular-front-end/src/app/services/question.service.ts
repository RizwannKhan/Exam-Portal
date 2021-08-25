import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class QuestionService {
  constructor(private _http: HttpClient) {}

  //get questions
  public getQuestionsOfQuiz(qid: any) {
    return this._http.get(`${baseUrl}/question/quiz/all/${qid}`);
  }

  //get questions for test
  public getQuestionsOfQuizForTest(qid: any) {
    return this._http.get(`${baseUrl}/question/quiz/${qid}`);
  }

  //add question
  public addQuestion(question: any) {
    return this._http.post(`${baseUrl}/question/`, question);
  }

  //delete question
  public deleteQuestion(questionId: any) {
    return this._http.delete(`${baseUrl}/question/${questionId}`);
  }

  //eval quiz from server
  public evalQuiz(questions: any){
    return this._http.post(`${baseUrl}/question/eval-quiz`, questions);
  }
}
