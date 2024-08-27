Function loadeventsound%(arg0.events, arg1$, arg2%)
    If (arg2 = $00) Then
        If (arg0\Field9 <> $00) Then
            freesound_strict(arg0\Field9)
            arg0\Field9 = $00
        EndIf
        arg0\Field9 = loadsound_strict(arg1)
        Return arg0\Field9
    ElseIf (arg2 = $01) Then
        If (arg0\Field10 <> $00) Then
            freesound_strict(arg0\Field10)
            arg0\Field10 = $00
        EndIf
        arg0\Field10 = loadsound_strict(arg1)
        Return arg0\Field10
    ElseIf (arg2 = $02) Then
        If (arg0\Field11 <> $00) Then
            freesound_strict(arg0\Field11)
            arg0\Field11 = $00
        EndIf
        arg0\Field11 = loadsound_strict(arg1)
        Return arg0\Field11
    EndIf
    Return $00
End Function
