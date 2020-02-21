import {Component, OnInit} from '@angular/core';
import {DemoService} from "../demo.service";
import {Demo, Message} from "./demo";


@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.scss']
})
export class DemoComponent implements OnInit {

  // message变量用于接受后端返回的信息。demodata存放需要发送的信息，
  // 这里需要初始化demodata。以防止在初始化的时候报错
  public message: any;
  public items: Array<string> = ['我是第一个新闻', '我是第二个新闻'];
  public demodata: Demo = {
    "id": null,
    "name": null,
    "height": null,
    "message": new Message(),
    "stringList": this.items
  };
  public demodatas: Demo[];

  // 在构建组件的同时就需要注入服务
  constructor(
    private demoService: DemoService,
  ) {
  }

  ngOnInit() {
  }

  // 输入框的change事件调用以更新demo的name
  updateName(value: string) {
    this.demodata.name = value;
  }

  // 输入框的change事件调用以更新demo的height
  updateHeight(value: number) {
    this.demodata.height = value;
  }

  // 输入框的change事件调用以更新demo的msg
  updateMsg(value: string) {
    this.demodata.message.msg = value;
  }

  // 增加新数据
  submitInfo() {
    // 调用demoService中的方法，该方法为Observable模式，调用subscribe
    // 方法进行后续处理，这里将获取的message赋予本组件变量。即可以通过
    // 双向绑定改变前端显示
    this.demoService.addToDatabase(this.demodata)
      .subscribe(data => {
        this.message = data.message.msg;
        this.demodata.stringList = data.stringList;
      })
  }

  // 查看已提交数据
  checkData() {
    this.demoService.checkDatabase()
      .subscribe(data => {
        this.demodatas = data
      })
  }

  // 清空所有数据
  clearData() {
    this.demoService.clearDatabase()
      .subscribe(msg => {
        this.message = msg.msg;
      })
  }
}
