import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Reactive1 } from './reactive1';

describe('Reactive1', () => {
  let component: Reactive1;
  let fixture: ComponentFixture<Reactive1>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Reactive1]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Reactive1);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
