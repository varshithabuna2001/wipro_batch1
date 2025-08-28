import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Reactive2 } from './reactive2';

describe('Reactive2', () => {
  let component: Reactive2;
  let fixture: ComponentFixture<Reactive2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Reactive2]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Reactive2);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
